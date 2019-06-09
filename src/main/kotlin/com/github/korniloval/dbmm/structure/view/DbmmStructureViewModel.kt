package com.github.korniloval.dbmm.structure.view

import com.github.korniloval.dbmm.psi.DbmmFile
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.openapi.editor.Editor

class DbmmStructureViewModel(psiFile: DbmmFile, editor: Editor?) :
    StructureViewModelBase(psiFile, editor, DbmmStructureViewElement(psiFile))
