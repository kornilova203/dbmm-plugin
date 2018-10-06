package com.github.korniloval.dbmm

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class DbmmFileType private constructor() : LanguageFileType(DbmmLanguage.INSTANCE) {

    companion object {
        val INSTANCE = DbmmFileType()
    }

    override fun getIcon(): Icon? {
        return AllIcons.Nodes.DataTables
    }

    override fun getName(): String {
        return "Dbmm"
    }

    override fun getDefaultExtension(): String {
        return "dbmm"
    }

    override fun getDescription(): String {
        return "Dbmm language file"
    }

}