package com.github.korniloval.dbmm.psi

import com.github.korniloval.dbmm.DbmmLanguage
import com.intellij.psi.tree.IElementType

class DbmmElementType(debugName: String) : IElementType(debugName, DbmmLanguage.INSTANCE)