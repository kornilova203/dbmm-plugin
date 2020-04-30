package com.github.korniloval.dbmm.lexer;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.korniloval.dbmm.psi.DbmmTypes.*;

%%

%{
    public static FlexAdapter getAdapter() {
        return new FlexAdapter(new DbmmLexer());
    }

    private DbmmLexer() {
        this(null);
    }
%}

%public
%class DbmmLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

WHITE_SPACE=\s+

WHITE_SPACE=[ \t\n\x0B\f\r]+
WHITE_SPACE_NO_LINE_BREAK=[ \t\x0B\f\r]+
COMMENT=(#|--)[^\n]*
OPTION=[1nip]
IDENTIFIER=[_a-zA-Z0-9]+

%state OPTIONS_STATE
%state LOOKING_FOR_JAVA_CODE_STATE
%state JAVA_CODE_STATE

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "family"           { return FAMILY; }
  "of"               { return OF; }
  "list"             { return LIST; }
  "set"              { return SET; }
  "property"         { return PROPERTY; }
  "abstract"         { return ABSTRACT; }
  "parent"           { return PARENT; }
  "entity"           { return ENTITY; }
  "internal"         { return INTERNAL; }
  "const"            { yybegin(LOOKING_FOR_JAVA_CODE_STATE); return CONST; }
  "default"          { yybegin(LOOKING_FOR_JAVA_CODE_STATE); return DEFAULT; }
  ":"                { return COLON; }
  ","                { return COMMA; }
  "."                { return DOT; }
  "["                { yybegin(OPTIONS_STATE); return RBRACKET; }


  {WHITE_SPACE}      { return WHITE_SPACE; }
  {COMMENT}          { return COMMENT; }
  {IDENTIFIER}       { return IDENTIFIER; }

  <<EOF>>            { return null; }
}

<OPTIONS_STATE> {
  {OPTION}                    { return OPTION; }
  "]"                         { yybegin(YYINITIAL); return LBRACKET; }
  .                           { return BAD_CHARACTER; }
}

<LOOKING_FOR_JAVA_CODE_STATE> {
  {WHITE_SPACE_NO_LINE_BREAK} / \n { yybegin(YYINITIAL); return WHITE_SPACE; }
  {WHITE_SPACE_NO_LINE_BREAK} { yybegin(JAVA_CODE_STATE); return WHITE_SPACE; }
  <<EOF>>                     { yybegin(YYINITIAL); }
}

<JAVA_CODE_STATE> {
  . / \n             { yybegin(YYINITIAL); return JAVA_CODE; }
  <<EOF>>            { yybegin(YYINITIAL); return JAVA_CODE; }
  .                  { }
}

[^] { return BAD_CHARACTER; }
