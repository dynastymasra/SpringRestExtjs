/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

Ext.define('SpringExtJS.view.mahasiswa.MahasiswaEditWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.mahasiswaEditWindow',
    title: 'Edit Mahasiswa',
    layout: 'fit',
    autoShow: true,
    resizable: false,
    modal: true,
    initComponent: function () {
        this.items = [
            {
                xtype: 'form',
                padding: '5 5 0 5',
                border: false,
                style: 'background-color: #fff;',
                defaults: {
                    width: 400
                },
                items: [
                    {
                        xtype: 'hiddenfield',
                        name: 'id'
                    },
                    {
                        xtype: 'textfield',
                        fieldLabel: 'Nim',
                        name: 'nim',
                        allowBlank: false
                    },
                    {
                        xtype: 'textfield',
                        fieldLabel: 'Name',
                        name: 'name',
                        allowBlank: false
                    },
                    {
                        xtype: 'textfield',
                        fieldLabel: 'Email',
                        name: 'email',
                        allowBlank: false
                    },
                    {
                        xtype: 'textfield',
                        fieldLabel: 'Phone',
                        name: 'phone',
                        allowBlank: false
                    },
                    {
                        xtype: 'combobox',
                        fieldLabel: 'Gender',
                        name: 'gender',
                        forceSelection: true,
                        allowBlank: false,
                        displayField: 'name',
                        valueField: 'name',
                        store: Ext.create('Ext.data.Store', {
                            fields: ['name'],
                            data: [
                                {"name": "Male"},
                                {"name": "Female"}
                            ]
                        })
                    },
                    {
                        xtype: 'datefield',
                        fieldLabel: 'Birth Date',
                        name: 'date',
                        allowBlank: false,
                        format: 'd F Y'
                    }
                ]
            }
        ];

        this.buttons = [
            {
                text: 'Save',
                action: 'save'
            },
            {
                text: 'Cancel',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    }
});