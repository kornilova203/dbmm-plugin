package com.github.korniloval.dbmm

import com.github.korniloval.dbmm.lexer.DbmmLexer
import com.github.korniloval.dbmm.psi.DbmmTypes
import com.github.korniloval.dbmm.psi.DbmmTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.KEYWORD
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.LINE_COMMENT
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType


class DbmmSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        private val BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val BAD_CHAR_KEYS: Array<TextAttributesKey?> = arrayOf(BAD_CHARACTER)
        private val COMMENT_KEYS = arrayOf(LINE_COMMENT)
        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val ID_KEYS = arrayOf(DefaultLanguageHighlighterColors.IDENTIFIER)
        private val EMPTY_KEYS = arrayOfNulls<TextAttributesKey>(0)
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey?> {
        if (tokenType == null) {
            return EMPTY_KEYS
        }
        return when (tokenType) {
            DbmmTypes.COMMENT -> COMMENT_KEYS

            DbmmTypes.IDENTIFIER -> ID_KEYS

            PROPERTY, OF, FAMILY, LIST, SET, ABSTRACT,
            CONST, PARENT, ENTITY, EXTERNAL, DEFAULT -> KEYWORD_KEYS

            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS

            else -> EMPTY_KEYS
        }
    }

    override fun getHighlightingLexer(): Lexer = DbmmLexer.getAdapter()
}
