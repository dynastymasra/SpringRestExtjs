/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

Ext.application({
    name: 'SpringExtJS',
    appFolder: 'resources/app',
    controllers: [
        'AppController', 'MahasiswaController'
    ],
    views: [],
    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype: 'panel',
                    title: 'Spring Rest Extjs ',
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            xtype: 'tabpanel',
                            flex: 1,
                            items: []
                        }
                    ],
                    tbar: [
                        {
                            xtype: 'button',
                            text: 'Mahasiswa',
                            action: 'mahasiswa'
                        }
                    ]
                }
            ]
        });
    }
});