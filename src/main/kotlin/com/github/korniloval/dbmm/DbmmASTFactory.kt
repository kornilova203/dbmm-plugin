package com.github.korniloval.dbmm

import com.github.korniloval.dbmm.psi.DbmmTypes
import com.intellij.lang.ASTFactory
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType

/**
 * @author Liudmila Kornilova
 **/
class DbmmASTFactory : ASTFactory() {
    override fun createComposite(type: IElementType): CompositeElement? {
        return DbmmTypes.Factory.createElement(type)
    }
}
