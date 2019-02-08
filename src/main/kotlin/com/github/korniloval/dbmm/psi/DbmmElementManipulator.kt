package com.github.korniloval.dbmm.psi

import com.github.korniloval.dbmm.psi.impl.DbmmElementRefImpl
import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator

/**
 * @author Liudmila Kornilova
 **/
class DbmmElementManipulator : AbstractElementManipulator<DbmmElementRefImpl>() {
    override fun handleContentChange(element: DbmmElementRefImpl, range: TextRange, newContent: String?): DbmmElementRefImpl? {
        TODO("not implemented")
    }
}
