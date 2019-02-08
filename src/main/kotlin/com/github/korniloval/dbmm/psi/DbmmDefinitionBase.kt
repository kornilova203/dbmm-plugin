package com.github.korniloval.dbmm.psi

import com.github.korniloval.dbmm.psi.DbmmTypes.IDENTIFIER
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.tree.IElementType

/**
 * @author Liudmila Kornilova
 **/
abstract class DbmmDefinitionBase(type: IElementType) : DbmmCompositePsiElement(type), PsiNameIdentifierOwner {
    override fun getNameIdentifier(): PsiElement? = getChildOfType(this, IDENTIFIER)

    override fun setName(name: String): PsiElement = TODO("not implemented")

    override fun getName(): String? = nameIdentifier?.text
}
