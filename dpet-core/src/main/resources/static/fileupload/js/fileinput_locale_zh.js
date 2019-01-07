/*!
 * FileInput Spanish (Latin American) Translations
 *
 * This file must be loaded after 'fileinput.js'. Patterns in braces '{}', or
 * any HTML markup tags in the messages must not be converted or translated.
 *
 * @see http://github.com/kartik-v/bootstrap-fileinput
 *
 * NOTE: this file must be saved in UTF-8 encoding.
 */
(function ($) {
    "use strict";
    $.fn.fileinput.locales.es = {
    		fileSingle: '单个文件',
            filePlural: '多个文件',
            browseLabel: '选择文件',
            removeLabel: '删除文件',
            removeTitle: '删除选中文件',
            cancelLabel: '取消',
            cancelTitle: '取消上传',
            uploadLabel: '上传',
            uploadTitle: '上传选中文件',
            msgSizeTooLarge: '文件 "{name}" (<b>{size} KB</b>) 超过了允许大小 <b>{maxSize} KB</b>.',
            msgFilesTooLess: '你必须选择最少 <b>{n}</b> {files} 来上传. ',
            msgFilesTooMany: '选择的上传文件个数 <b>({n})</b> 超出最大文件的限制个数 <b>{m}</b>.',
            msgFileNotFound: '文件 "{name}" 未找到!',
            msgFileSecured: '安全限制，为了防止读取文件 "{name}".',
            msgFileNotReadable: '文件 "{name}" 不可读.',
            msgFilePreviewAborted: '取消 "{name}" 的预览.',
            msgFilePreviewError: '读取 "{name}" 时出现了一个错误.',
            msgInvalidFileType: '不正确的类型 "{name}". 只支持 "{types}" 类型的文件.',
            msgInvalidFileExtension: '不正确的文件扩展名 "{name}". 只支持 "{extensions}" 的文件扩展名.',
            msgValidationError: '验证错误',
            msgLoading: '加载第 {index} 文件 共 {files} &hellip;',
            msgProgress: '加载第 {index} 文件 共 {files} - {name} - {percent}% 完成.',
            msgSelected: '选中{n}个文件',
            msgFoldersNotAllowed: '只支持拖拽文件! 跳过 {n} 拖拽的文件夹.',
            dropZoneTitle: '拖拽文件到这里'
    };

    $.extend($.fn.fileinput.defaults, $.fn.fileinput.locales.es);
})(window.jQuery);
