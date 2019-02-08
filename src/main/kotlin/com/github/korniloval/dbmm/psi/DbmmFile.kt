package com.github.korniloval.dbmm.psi

import com.github.korniloval.dbmm.DbmmFileType
import com.github.korniloval.dbmm.DbmmLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.util.PsiTreeUtil

/**
 * @author Liudmila Kornilova
 **/
class DbmmFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, DbmmLanguage.INSTANCE) {
    override fun getFileType(): FileType = DbmmFileType.INSTANCE

    override fun toString(): String = "dbmm File"

    override fun processDeclarations(processor: PsiScopeProcessor, state: ResolveState,
                                     lastParent: PsiElement?, place: PsiElement): Boolean {
        PsiTreeUtil.getChildrenOfTypeAsList(this, DbmmDefinitionBase::class.java).forEach { def ->
            if (!processor.execute(def, state)) return false
        }
        return false
    }

}
