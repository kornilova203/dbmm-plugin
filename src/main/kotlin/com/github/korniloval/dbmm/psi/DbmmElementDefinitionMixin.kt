package com.github.korniloval.dbmm.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.tree.IElementType

/**
 * @author Liudmila Kornilova
 **/
abstract class DbmmElementDefinitionMixin(type: IElementType) : DbmmDefinitionBase(type), DbmmElementDefinition {
}
