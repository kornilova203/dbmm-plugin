package com.github.korniloval.dbmm

import com.github.korniloval.dbmm.psi.DbmmCompositePsiElement
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement

/**
 * @author Liudmila Kornilova
 **/
class DbmmFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner? = null

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String = ""

    override fun getDescriptiveName(element: PsiElement): String = ""

    override fun getType(element: PsiElement): String = ""

    override fun getHelpId(psiElement: PsiElement): String? = null

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean = psiElement is DbmmCompositePsiElement
}
