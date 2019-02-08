package com.github.korniloval.dbmm

import com.github.korniloval.dbmm.psi.DbmmElementRef
import com.github.korniloval.dbmm.psi.DbmmResolvingScopeProcessor
import com.intellij.json.psi.JsonProperty
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ArrayUtil
import com.intellij.util.IncorrectOperationException

/**
 * @author Liudmila Kornilova
 **/
class DbmmReference(element: DbmmElementRef) : PsiReferenceBase<DbmmElementRef>(element) {
    override fun resolve(): PsiElement? = resolveInner()

    private fun resolveInner(): PsiElement? {
        val processor = DbmmResolvingScopeProcessor(this)
        val containingFile = myElement.containingFile
        PsiTreeUtil.treeWalkUp(processor, myElement, containingFile, ResolveState.initial())
        return if (processor.declaration == myElement) null else processor.declaration
    }

    override fun getVariants(): Array<Any> = emptyArray()
}
