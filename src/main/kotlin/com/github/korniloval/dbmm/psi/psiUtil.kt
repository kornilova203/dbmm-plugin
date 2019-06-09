package com.github.korniloval.dbmm.psi

import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

fun getChildOfType(e: PsiElement?, type: IElementType?): PsiElement? {
    if (e == null || type == null) return null
    val child = e.firstChild
    return if (child == null) null else PsiTreeUtil.findSiblingForward(child, type, false, null)
}

fun getPresentation(e: DbmmElement): ItemPresentation {
    return object : ItemPresentation {
        override fun getLocationString(): String? = null

        override fun getIcon(unused: Boolean): Icon? = null

        override fun getPresentableText(): String? = e.name
    }
}
