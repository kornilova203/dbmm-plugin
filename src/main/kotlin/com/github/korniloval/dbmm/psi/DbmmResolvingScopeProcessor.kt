package com.github.korniloval.dbmm.psi

import com.github.korniloval.dbmm.DbmmReference
import com.intellij.openapi.util.Key
import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor

/**
 * @author Liudmila Kornilova
 **/
class DbmmResolvingScopeProcessor(private val myReference: DbmmReference) : PsiScopeProcessor {
    var declaration: DbmmDefinitionBase? = null

    override fun execute(def: PsiElement, state: ResolveState): Boolean {
        if (def !is DbmmDefinitionBase) return true
        if (def.nameIdentifier?.text == myReference.element.text) {
            this.declaration = def
            return false
        }
        return true
    }

    override fun <T : Any?> getHint(hintKey: Key<T>): T? {
        return null
    }

    override fun handleEvent(event: PsiScopeProcessor.Event, associated: Any?) {
    }
}
