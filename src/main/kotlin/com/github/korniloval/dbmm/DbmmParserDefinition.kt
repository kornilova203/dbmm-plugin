package com.github.korniloval.dbmm

import com.github.korniloval.dbmm.lexer.DbmmLexer
import com.github.korniloval.dbmm.psi.DbmmFile
import com.github.korniloval.dbmm.psi.DbmmTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

/**
 * @author Liudmila Kornilova
 **/
class DbmmParserDefinition : ParserDefinition {
    companion object {
        val COMMENTS = TokenSet.create(DbmmTypes.COMMENT)
        val FILE = IFileElementType(DbmmLanguage.INSTANCE)
    }

    override fun createParser(project: Project?): PsiParser = DbmmGeneratedParser()

    override fun createFile(viewProvider: FileViewProvider?): PsiFile? {
        if (viewProvider == null) {
            return null
        }
        return DbmmFile(viewProvider)
    }

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun getFileNodeType(): IFileElementType = FILE

    override fun createLexer(project: Project?): Lexer = DbmmLexer.getAdapter()

    override fun createElement(node: ASTNode?): PsiElement = throw AssertionError()

    override fun getCommentTokens(): TokenSet = COMMENTS
}
