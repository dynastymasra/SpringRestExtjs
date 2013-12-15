/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

Ext.define('SpringExtJS.controller.MahasiswaController', {
    extend: 'Ext.app.Controller',

    views: [
        'mahasiswa.MahasiswaGridList',
        'mahasiswa.MahasiswaEditWindow'
    ],

    stores: ['MahasiswaStore'],

    refs: [
        {
            ref: 'mahasiswaGridList',
            selector: 'mahasiswaGridList'
        },
        {
            ref: 'mahasiswaGridListDeleteButton',
            selector: 'mahasiswaGridList button[action=delete]'
        },
        {
            ref: 'mahasiswaEditWindow',
            selector: 'mahasiswaEditWindow'
        },
        {
            ref: 'mahasiswaEditWindowForm',
            selector: 'mahasiswaEditWindow form'
        }
    ],

    init: function () {
        this.control({
            'mahasiswaGridList': {
//                selectionchange: this.mahasiswaGridListSelectionChange,
//                itemdblclick: this.mahasiswaGridListItemDblClick
            },
            'mahasiswaGridList button[action=add]': {
                click: this.buttonAddMahasiswaClick
            },
            'mahasiswaGridList button[action=delete]': {
                click: this.buttonDeleteMahasiswaClick
            },
            'mahasiswaEditWindow button[action=save]': {
                click: this.mahasiswaEditWindowButtonSaveClick
            }
        })
    },

    buttonDeleteMahasiswaClick: function () {
        var me = this;
        Ext.Msg.show({
            title: 'Are u sure?',
            msg: 'Are u sure?',
            width: 300,
            buttons: Ext.Msg.YESNO,
            icon: Ext.window.MessageBox.INFO,
            fn: function (buttonId) {
                if (buttonId == 'yes') {
                    me.deleteMahasiswa();
                }
            }
        });
    },

    deleteMahasiswa: function () {
        var me = this;
        var record = this.getMahasiswaGridList().getSelectionModel().getSelection()[0];
        if (record) {
//            Ext.Ajax.request({
//                url: mahasiswaApiUrl + "?id=" + record.data.id,
//                method: 'DELETE',
//                headers: {
//                    'Content-Type': 'application/json'
//                },
//                success: function (response, options) {
//                    me.getMahasiswaGridList().getStore().reload();
//                },
//                failure: function (response, options) {
//                }
//            });
        }
    },

    mahasiswaGridListSelectionChange: function (selectionModel, selected) {
        this.getMahasiswaGridListDeleteButton().disable();
        if (!Ext.isEmpty(selected)) {
            this.getMahasiswaGridListDeleteButton().enable();
        }
    },

    buttonAddMahasiswaClick: function () {
        var windowEdit = Ext.create('SpringExtJS.view.mahasiswa.MahasiswaEditWindow');
        windowEdit.show();
    },

    mahasiswaGridListItemDblClick: function (view, record) {
        var windowEdit = Ext.widget('mahasiswaEditWindow');
        windowEdit.show();
        windowEdit.down('form').loadRecord(record);
    },

    mahasiswaEditWindowButtonSaveClick: function () {
        var me = this;
        var form = this.getMahasiswaEditWindowForm();
        var values = form.getValues();
        var record = form.getRecord();

        console.info("values", values.date);

        if (form.getForm().isValid()) {
            values.date = Ext.Date.format(Ext.Date.parse(values.date, 'd F Y'), 'c');
            console.info("values", values.date);

            if (record) {//jika ada record berarti meng-update data lama
                Ext.Ajax.request({
                    url: mahasiswaApiUrl + "?id=" + record.data.id,
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    params: Ext.JSON.encode(values),
                    success: function (response, options) {
                        me.getMahasiswaGridList().getStore().reload();
                    },
                    failure: function (response, options) {
                    }
                });
            } else {//tidak ada record berarti data baru
                Ext.Ajax.request({
                    url: mahasiswaApiUrl,
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    params: Ext.JSON.encode(values),
                    success: function (response, options) {
                        me.getMahasiswaGridList().getStore().reload();
                    },
                    failure: function (response, options) {
                    }
                });
            }
            this.getMahasiswaEditWindow().close();
        }
    }
});