jQuery(function($) {

    $('.ad-index-btn-menu').click(function() {
        $('.ad-index-menu').sidebar('toggle');
    });

    if ($('#context').size() == 1) {
        $('.ui.sticky').sticky({
            offset: 70,
            context: '#context'
        });
    }

    $('.ad-index-logout').click(function() {
        $(this).siblings('form').submit();
    });

    $('.ui.accordion').accordion();
    $('.ui.checkbox').checkbox();

    // load markdown help content
    if ($('.markdown-content').size() > 0) {
        var converter = new showdown.Converter();
        $('.markdown-content').each(function(index, el) {
            $.get($(el).attr('data-url'), function(data) {
                $('<div class="markdown-body"/>').html(converter.makeHtml(data)).appendTo(el);
            });
        });
    }

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

    $(document).ajaxStart(function() {
        $('.page-dimmer').addClass('active');
    });

    $(document).ajaxComplete(function() {
        $('.page-dimmer').removeClass('active');
    });


    $('.ad-item-feedback').click(function(event) {
        event.stopImmediatePropagation();
        $(this).find('form').find(':hidden[name="name"]').val($('title').text()).end().submit();
    });

    $('.ad-add-image').click(function(event) {
        window.imgSelectFor = $(this).attr('data-for');

        $.post('admin/file/list', {
                timestamp: new Date().getTime()
            },
            function(data, textStatus, xhr) {
                if (data.success) {
                    $("#imageItemTpl").tmpl(data.data.imgs, data.data).appendTo($('.ad-images .cards').empty());
                    $('.ui.checkbox').checkbox();

                    $('.ad-images').modal('show');
                } else {
                    toastr.error(data.data, '图片加载失败!');
                }
            });
    });

    $('.ad-images.modal > .content').on('click', '.image', function(event) {
        $(this).parents('.card').find('.ui.checkbox').checkbox("toggle");
    });

    $('.ad-images.modal').modal({
        closable: false,
        onApprove: function() {
            var imgSrcArr = [];
            $('.cards').find('input:checked').parents('.card').find('img').each(function(index, el) {
                imgSrcArr.push($(el).attr('data-src'));
            });

            if (imgSrcArr.length > 0) {
                if (!!imgSelectedCallback) {
                    imgSelectedCallback(imgSrcArr, window.imgSelectFor);
                }
            } else {
                toastr.error('您没有选择图片!');
                return false;
            }
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
        },
        abbreviate: function(str, len) {
            if (!!str && str.length > len) {
                return str.substring(0, len - 3) + "...";
            }

            return str;
        }
    });
});
