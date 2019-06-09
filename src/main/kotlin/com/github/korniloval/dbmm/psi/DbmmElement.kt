package com.github.korniloval.dbmm.psi

import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.psi.PsiElement

interface DbmmElement : PsiElement, NavigationItem {
    override fun getPresentation(): ItemPresentation
}
