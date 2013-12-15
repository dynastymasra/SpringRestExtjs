/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

Ext.define('SpringExtJS.controller.AppController', {
    extend: 'Ext.app.Controller',

    refs: [
        {
            ref: 'tabpanel',
            selector: 'viewport panel tabpanel'
        }
    ],

    init: function () {
        this.control({
            'button[action=mahasiswa]': {
                click: this.buttonMahasiswaClick
            }
        })
    },
    showActiveTab: function (displayType) {
        var tabpanel = this.getTabpanel();
        var panel = tabpanel.child(displayType);
        if (Ext.isEmpty(panel)) {
            tabpanel.add({
                xtype: displayType,
                tabConfig: {
                    xtype: 'tab',
                    closable: true
                }
            });
            panel = tabpanel.child(displayType);
        }
        tabpanel.setActiveTab(panel);
    },
    buttonMahasiswaClick: function () {
        this.showActiveTab('mahasiswaGridList');
    }
});