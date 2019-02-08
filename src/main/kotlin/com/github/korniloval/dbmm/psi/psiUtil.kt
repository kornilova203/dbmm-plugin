package com.github.korniloval.dbmm.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil

fun getChildOfType(e: PsiElement?, type: IElementType?): PsiElement? {
    if (e == null || type == null) return null
    val child = e.firstChild
    return if (child == null) null else PsiTreeUtil.findSiblingForward(child, type, false, null)
}