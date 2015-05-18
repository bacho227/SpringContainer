window.glyphs = {
    get: function (name) {
        return 'x' + name + '@FontAwesome';
    },
    user: 'f007',
    edit: 'f044',
    history: 'f1da',
    back: 'f060',
    print: 'f02f',
    details: 'f013',
    groups: 'f0c0',
    documents: 'f1c6',
    plusCircle: 'f055',
    file: 'f15b',
    save: 'f0c7',
    chevronCircleDown: 'f13a',
    university: 'f19c',
    list: 'f03a',
    gears: 'f085',
    close: 'f00d',
    checkCircle: 'f058',
    check: 'f00c',
    bell: 'f0f3',
    thumbsUp: 'f164',
    barChart: 'f080',
    tasks: 'f0ae',
    search: 'f002',
    refresh: 'f021',
    folderOpen: 'f07c',
    fileText: 'f15c',
    send: 'f1d8',
    eye: 'f06e',
    clients: 'f0c0',
    loans: 'f0d6',
    card: 'f09d',
    logout: 'f08b',
    brush: 'f1fc',
    clip: 'f0c6',
    minusCircle: 'f056'
};

function log() {
    if (document.all)
        return;
    console.log.apply(console, arguments);
}

function monitorEvents(obj) {
    Ext.util.Observable.capture(obj, function (evname, args) {
        log(evname, [args]);
    });
}

function query() {
    var res = Ext.ComponentQuery.query.apply(Ext.ComponentQuery, arguments);
    return res.length === 1 ? res[0] : res;
}

function request(options) {
    if (!options.url)
        return;
    options.method = options.method || options.type || 'POST';
    emptyString2Null(options.jsonData);
    var successFn = options.success;
    options.success = function (response) {
        if (Ext.isFunction(successFn)) {
            var res;
            try {
                res = response.responseText.replace(/\n/g, '');
                res = Ext.decode(res);
            } catch (e) {
                res = response.responseText;
            }
            return successFn.call(null, res);
        }
    };
    return Ext.Ajax.request(options);
}

function getExceptionMessage(s) {
    s = s.substr(s.indexOf("Exception:") + 0);
    s = s.substr(s.indexOf(":") + 2, s.indexOf("h1") - 13);
    log(s);
    return s;
}

function relayoutWindows() {
    clearTimeout(window.relayoutWindowsT);
    window.relayoutWindowsT = setTimeout(function () {
        Ext.WindowManager.each(function (win) {
            if (Ext.isFunction(win.doLayout)) {
                win.doLayout();
                win.center();
            }
        });
    }, 100);
}

function emptyString2Null(obj) {
    for (var i in obj) {
        if (obj[i] === "" || obj[i] === undefined) {
            delete obj[i];
        } else if (obj[i].constructor === (new Object()).constructor) {
            emptyString2Null(obj[i]);
        } else if (obj[i].constructor === (new Array()).constructor) {
            for (var j in obj[i]) {
                emptyString2Null(obj[i][j]);
            }
        }
    }
}