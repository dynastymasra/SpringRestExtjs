/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

Ext.define('SpringExtJS.view.mahasiswa.MahasiswaGridList', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.mahasiswaGridList',
    title: 'Mahasiswa List',
    forceFit: true,
    initComponent: function () {
        var store = Ext.create('SpringExtJS.store.MahasiswaStore');
        var me = this;
        Ext.apply(this, {
            store: store,
            columns: [
/*                new Ext.grid.RowNumberer(),
                {
                    header: 'NIM',
                    dataIndex: 'nim',
                    flex: 1,
                    align: 'center'
                },
                {
                    header: 'Name',
                    dataIndex: 'name',
                    flex: 3
                },
                {
                    header: 'Email',
                    dataIndex: 'email',
                    flex: 1,
                    align: 'center'
                },
                {
                    header: 'Phone',
                    dataIndex: 'phone',
                    flex: 1,
                    align: 'center'
                },
                {
                    header: 'Gender',
                    dataIndex: 'gender',
                    flex: 1,
                    align: 'center'
                },*/
                Ext.create('Ext.grid.RowNumberer', {
                    flex:1,
                    maxWidth: 50
                }),
                {
                    xtype: 'gridcolumn',
                    flex:1,
                    dataIndex: 'nim',
                    text: 'Nim'
                },
                {
                    xtype: 'gridcolumn',
                    flex:1,
                    dataIndex: 'name',
                    text: 'Name'
                },
                {
                    xtype: 'datecolumn',
                    align: 'center',
                    dataIndex: 'date',
                    text: 'Birth Date',
                    format: 'd F Y',
                    flex: 1
                }
            ],
            dockedItems: [
                {
                    xtype: 'toolbar',
                    dock: 'top',
                    items: [
                        {
                            xtype: 'button',
                            text: 'New Mahasiswa',
                            disabled: false,
                            action: 'add'
                        },
                        {
                            xtype: 'button',
                            text: 'Delete Mahasiswa',
                            disabled: true,
                            action: 'delete'
                        } ,
                        {
                            xtype: 'button',
                            text: 'New Task',
                            disabled: false,
                            action: 'newTask',
                            listeners: {
                                click: function () {
                                    Ext.Msg.alert('Status', me.selectItem.data);
                                }
                            }
                        }
                    ]
                },
                {
                    xtype: 'pagingtoolbar',
                    dock: 'bottom',
                    store: store,
                    displayInfo: true,
                    displayMsg: 'Displaying Mahasiswa {0} - {1} of {2}',
                    emptyMsg: 'No Mahasiswa to display'
                }
            ]
        });
        this.callParent(arguments);

    },
    listeners: {
        selectionchange: function (cmp, rec) {
            this.selectItem = rec[0];
            console.info(rec, "test");

        },
        itemdblclick: function () {
            console.info(arguments);

        }
    },
    selectItem: null
});