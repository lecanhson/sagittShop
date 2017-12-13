
(function(e) {

"use strict";

    function u() {
        r = false;
        for (var n = 0; n < t.length; n++) {
            var i = e(t[n]).filter(function() {
                return e(this).is(":appeared")
            });
            i.trigger("appear", [i]);
            if (o) {
                var s = o.not(i);
                s.trigger("disappear", [s])
            }
            o = i
        }
    }
    var t = [];
    var n = false;
    var r = false;
    var i = {
        interval: 250,
        force_process: false
    };
    var s = e(window);
    var o;
    e.expr[":"]["appeared"] = function(t) {
        var n = e(t);
        if (!n.is(":visible")) {
            return false
        }
        var r = s.scrollLeft();
        var i = s.scrollTop();
        var o = n.offset();
        var u = o.left;
        var a = o.top;
        if (a + n.height() >= i && a - (n.data("appear-top-offset") || 0) <= i + s.height() && u + n.width() >= r && u - (n.data("appear-left-offset") || 0) <= r + s.width()) {
            return true
        } else {
            return false
        }
    };
    e.fn.extend({
        appear: function(s) {
            var o = e.extend({}, i, s || {});
            var a = this.selector || this;
            if (!n) {
                var f = function() {
                    if (r) {
                        return
                    }
                    r = true;
                    setTimeout(u, o.interval)
                };
                e(window).scroll(f).resize(f);
                n = true
            }
            if (o.force_process) {
                setTimeout(u, o.interval)
            }
            t.push(a);
            return e(a)
        }
    });
    e.extend({
        force_appear: function() {
            if (n) {
                u();
                return true
            }
            return false
        }
    })
})(jQuery);
(function(e) {
    "$:nomunge";

    function i(n) {
        function p() {
            if (n) {
                s.removeData(n)
            } else if (l) {
                delete t[l]
            }
        }

        function d() {
            o.id = setTimeout(function() {
                o.fn()
            }, c)
        }
        var i = this,
            s, o = {},
            u = n ? e.fn : e,
            a = arguments,
            f = 4,
            l = a[1],
            c = a[2],
            h = a[3];
        if (typeof l !== "string") {
            f--;
            l = n = 0;
            c = a[1];
            h = a[2]
        }
        if (n) {
            s = i.eq(0);
            s.data(n, o = s.data(n) || {})
        } else if (l) {
            o = t[l] || (t[l] = {})
        }
        o.id && clearTimeout(o.id);
        delete o.id;
        if (h) {
            o.fn = function(e) {
                if (typeof h === "string") {
                    h = u[h]
                }
                h.apply(i, r.call(a, f)) === true && !e ? d() : p()
            };
            d()
        } else if (o.fn) {
            c === undefined ? p() : o.fn(c === false);
            return true
        } else {
            p()
        }
    }
    var t = {},
        n = "doTimeout",
        r = Array.prototype.slice;
    e[n] = function() {
        return i.apply(window, [0].concat(r.call(arguments)))
    };
    e.fn[n] = function() {
        var e = r.call(arguments),
            t = i.apply(this, [n + e[0]].concat(e));
        return typeof e[0] === "number" || typeof e[1] === "number" ? this : t
    };
})(jQuery);

$(".animatedParent").appear();

$(document.body).on('appear', '.animatedParent', function(e, $affected) {
    if ($(window).width() >= 768) {
        var delay, ele = $(this).find('.animated');
        var parent = $(this);
        if (parent.attr('data-sequence') != undefined) {

            var firstId = $(this).find('.animated:first').attr('data-id');
            var number = firstId;
            var lastId = $(this).find('.animated:last').attr('data-id');

            $(parent).find(".animated[data-id=" + number + "]").addClass('go');
            number++;
            delay = Number(parent.attr('data-sequence'));

            $.doTimeout(delay, function() {
                $(parent).find(".animated[data-id=" + number + "]").addClass('go');
                ++number;
                if (number <= lastId) {
                    return true;
                }
            });
        } else {
            ele.addClass('go');
        }
    }

});

$(document.body).on('disappear', '.animatedParent', function(e, $affected) {
    if ($(window).width() >= 768) {
        if ($(this).hasClass('repeatAnimation')) {
            $(this).find('.animated').removeClass('go');
        }
    }
});

$(window).load(function() {
    $.force_appear();
});