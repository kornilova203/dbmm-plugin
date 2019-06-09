package com.github.korniloval.dbmm.structure.view

import com.github.korniloval.dbmm.psi.DbmmDefinitionBase
import com.github.korniloval.dbmm.psi.DbmmElement
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement

class DbmmStructureViewElement(private val myElement: DbmmElement) : StructureViewTreeElement {

    override fun getValue(): PsiElement = myElement

    override fun navigate(requestFocus: Boolean) = myElement.navigate(requestFocus)

    override fun canNavigate(): Boolean = myElement.canNavigate()

    override fun canNavigateToSource(): Boolean = myElement.canNavigateToSource()

    override fun getPresentation(): ItemPresentation = myElement.presentation

    override fun getChildren(): Array<TreeElement> {
        return myElement.children
            .filterIsInstance(DbmmDefinitionBase::class.java)
            .map { DbmmStructureViewElement(it) }
            .toTypedArray()
    }
}
