package com.github.korniloval.dbmm

import com.intellij.lang.Language

/**
 * @author Liudmila Kornilova
 **/
class DbmmLanguage private constructor() : Language("Dbmm") {
    companion object {
        val INSTANCE = DbmmLanguage()
    }
}
