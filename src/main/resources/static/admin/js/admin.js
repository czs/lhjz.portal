jQuery(function($) {

    $('.ad-index-btn-menu').click(function() {
        $('.ad-index-menu').sidebar('toggle');
    });

    $('.ui.sticky').sticky({
        offset: 70,
        //pushing: true,
        //ottomOffset: 84,
        //context: '.ad-index-container'
        //context: '.context'
    });

    $('.ad-index-logout').click(function() {
        $(this).siblings('form').submit();
    });

    $('.ui.accordion').accordion();
    $('.ui.checkbox').checkbox();

    // semantic-ui ajax api
    $.fn.api.settings.api = {
        'deleteFileById': 'admin/file/delete?id={id}',
        'updateFileName': 'admin/file/update?id={id}&name={name}',
        'saveArticle': 'admin/article/save',
        'updateArticle': 'admin/article/update?id={id}',
        'deleteArticleById': 'admin/article/delete?id={id}',
        'saveFeedback': 'admin/feedback/save'
    };

    $.fn.api.settings.successTest = function(resp) {
        if (resp && resp.success) {
            return resp.success;
        }
        return false;
    };

    // toastr notification options
    if ("undefined" != typeof toastr) {
        toastr.options = {
            "closeButton": true,
            "debug": false,
            "newestOnTop": true,
            "progressBar": false,
            "positionClass": "toast-bottom-center",
            "preventDuplicates": false,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        };
    }

    $(document).ajaxSend(function(event, jqxhr, settings) {

        var csrf = {};
        csrf[$('.ad-csrf input:hidden').attr('name')] = $('.ad-csrf input:hidden').attr('value');

        if (!!settings.data) {
            settings.data = settings.data + "&" + $.param(csrf);
        } else {
            settings.data = $.param(csrf);
        }
    });

    $('.ad-item-feedback').click(function(event) {
        event.stopImmediatePropagation();
        $(this).find('form').find(':hidden[name="name"]').val($('title').text()).end().submit();
    });

    $('.ad-add-image').click(function(event) {
        $('.ad-images').modal('show');
    });

    $('.ad-images.modal').modal({
        closable: false,
        onDeny: function() {
            return true;
        },
        onApprove: function() {
            var imgSrc = $('.cards').find('input:checked').parents('.card').find('img').attr('src');
            if (!!imgSrc) {
                if (!!imgSelectedCallback) {
                    imgSelectedCallback(imgSrc);
                }
            } else {
                toastr.error('您没有选择图片!');
                return false;
            }

        },
        onShow: function() {
            var data = {};
            data[$('.ad-csrf input:hidden').attr('name')] = $('.ad-csrf input:hidden').attr('value');
            $.post('admin/file/list', data,
                function(data, textStatus, xhr) {
                    $("#imageItemTpl").tmpl(data.data.imgs).appendTo($('.ad-images .cards').empty());
                    $('.ui.checkbox').checkbox();
                });
        },
        onVisible: function() {
            $('.ad-images.modal').modal('refresh');
        }
    });

});

jQuery(function($) {
    // custom helper utils
    window.Utils = window.Utils || {};

    $.extend(window.Utils, {
        removeFileType: function(name) {
            var i = name.lastIndexOf('.');
            return (i != -1) ? name.substring(0, i) : name;
        },
        getFileType: function(name) {
            var i = name.lastIndexOf('.');
            return (i != -1) ? name.substring(i) : '';
        }
    });
});
