package com.github.korniloval.dbmm.psi

import com.github.korniloval.dbmm.DbmmFileType
import com.github.korniloval.dbmm.DbmmLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

/**
 * @author Liudmila Kornilova
 **/
class DbmmFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider,
    DbmmLanguage.INSTANCE
) {
    override fun getFileType(): FileType = DbmmFileType.INSTANCE

    override fun toString(): String = "dbmm File"

}
