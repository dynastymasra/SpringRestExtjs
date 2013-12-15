/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */

Ext.define('SpringExtJS.store.MahasiswaStore', {
    extend: 'Ext.data.Store',
    model: 'SpringExtJS.model.Mahasiswa',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        pageParam: 'page.page',
        url: Config.mahasiswaUrl,
        reader: {
            type: 'json',
            root: 'content',
            totalProperty: 'totalElements'
        }
    },
    pageSize: 1,
    remoteSort: true ,
    sorters:{
        property: 'name',
        direction: 'DESC'
    },
    listeners: {
        'beforeload': function (store, operation) {
            var self = this;
            operation.params = {};
            if (!Ext.isEmpty(self.pageSize)) {
                operation.params['page.size'] = self.pageSize;
            }

            if (!Ext.isEmpty(operation.sorters) && self.remoteSort) {
                var sorter = operation.sorters[0];
                operation.params["page.sort"] = sorter.property;
                operation.params["page.sort.dir"] = sorter.direction;
            }
        }
    }
});