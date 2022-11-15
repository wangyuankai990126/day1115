new Vue({
    el:'#companydiv',
    data:{
        list:[],
        pageInfo:{},
        pageNum:1,
        pageSize:2,
        searchEntity:{},
        cids:[],
        goods:{}
    },
    methods:{

        paging:function(pageNum){
            if(pageNum==0){
                pageNum = 1;
            }
            this.pageNum = pageNum;
            this.findAllConnAndPage();
        },
        findAllConnAndPage:function(){
            var _this = this;
            var url = '../manager/findAllConnAndPage?pageNum='+this.pageNum+"&pageSize="+this.pageSize;
            axios.post(url,_this.searchEntity).then(function (response) {
                _this.list = response.data.list;
                _this.pageNum = response.data.pageNum;
                _this.pageSize = response.data.pageSize;
                _this.pageInfo = response.data;
            });
        },
        //批量删除
        deleteAll:function(){
            if (confirm("确定删除选中的吗?")) {
                if (this.cids != null && this.cids.length >= 1) {
                    var _this = this;
                    axios.post('../manager/deleteAll', _this.cids).then(function (response) {
                        if (response.data.flag) {
                            _this.findAllConnAndPage();
                        } else {
                            alert(response.data.msg);
                        }
                    });
                }
            }
        },
        // 点击添加按钮
        toAddGoods:function () {
            document.getElementById("goodsadddiv").style.display="block";
        },
        //添加
        saveGoods:function(){
            var _this = this;
            var url="../manager/saveOrUpdateGoods";
            if (confirm("确定添加吗?")) {
                axios.post(url, _this.goods).then(function (response) {
                    if (response.data.flag) {
                        _this.findAllConnAndPage();
                        document.getElementById("goodsadddiv").style.display = "none";
                    } else {
                        alert(response.data.msg);
                    }
                });
            }
        },

    },
    created:function () {
        this.findAllConnAndPage();
    }
});