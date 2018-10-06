package com.github.korniloval.dbmm.highlight

import com.github.korniloval.dbmm.psi.DbmmElementName
import com.github.korniloval.dbmm.psi.DbmmFieldName
import com.github.korniloval.dbmm.psi.DbmmInterfaceOrKind
import com.github.korniloval.dbmm.psi.DbmmTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.psi.PsiElement
import java.util.regex.Pattern

/**
 * @author Liudmila Kornilova
 **/
class DbmmAnnotator : Annotator {
    private val kindPattern = Pattern.compile("[_A-Z]+")

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is ASTNode) return
        if (element.elementType == DbmmTypes.IDENTIFIER) {
            val annotation = holder.createInfoAnnotation(element as PsiElement, null)
            when (element.parent) {
                is DbmmElementName -> annotation.textAttributes = INTERFACE_NAME
                is DbmmFieldName -> annotation.textAttributes = INSTANCE_FIELD
                is DbmmInterfaceOrKind ->
                    if (kindPattern.matcher((element as PsiElement).text).matches())
                        annotation.textAttributes = STATIC_FIELD
            }
        }
    }
}
