package com.github.korniloval.dbmm.psi

import com.github.korniloval.dbmm.DbmmReference
import com.github.korniloval.dbmm.psi.DbmmTypes.IDENTIFIER
import com.intellij.psi.PsiReference
import com.intellij.psi.tree.IElementType

/**
 * @author Liudmila Kornilova
 **/
abstract class DbmmElementRefMixin(type: IElementType) : DbmmCompositePsiElement(type), DbmmElementRef {
    override fun getReference(): PsiReference? = DbmmReference(this)

    override fun getName(): String? = getChildOfType(this, IDENTIFIER)?.text
}
