package com.github.korniloval.dbmm

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory

class DbmmFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(consumer: FileTypeConsumer) {
        consumer.consume(DbmmFileType.INSTANCE, DbmmFileType.INSTANCE.defaultExtension)
    }
}
