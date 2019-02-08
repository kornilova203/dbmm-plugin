package com.github.korniloval.dbmm.highlight

import com.github.korniloval.dbmm.psi.*
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
        if (element.node.elementType == DbmmTypes.IDENTIFIER) {
            val annotation = holder.createInfoAnnotation(element, null)
            when (element.parent) {
                is DbmmElementDefinition -> annotation.textAttributes = INTERFACE_NAME
                is DbmmElementRef -> annotation.textAttributes = INSTANCE_FIELD
                is DbmmInterfaceOrKind ->
                    if (kindPattern.matcher(element.text).matches())
                        annotation.textAttributes = STATIC_FIELD
            }
        }
    }
}
