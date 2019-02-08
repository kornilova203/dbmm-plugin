package com.github.korniloval.dbmm.psi

import com.intellij.psi.impl.source.tree.CompositePsiElement
import com.intellij.psi.tree.IElementType

/**
 * @author Liudmila Kornilova
 **/
abstract class DbmmCompositePsiElement(type: IElementType) : CompositePsiElement(type) {
    override fun toString(): String {
        return "${javaClass.simpleName}($elementType)"
    }
}
