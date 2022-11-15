new Vue({
    el:"#indexdiv",
    data:{
        manager:{},
    },
    methods:{
        getLogin:function () {
            var _this=this;
            var url="../manager/login";
            if (_this.manager.username==undefined||_this.manager.password==undefined){
                alert("账号密码不可以为空！")
            }else {
                axios.post(url,_this.manager).then(function (response) {
                    if (response.data=="ok"){
                        alert("登录成功")
                        location.href="../main/managerList";
                    }else {
                        alert("登录失败")
                        location.href="../main/index";
                    }
                })
            }
        }
    },
    created:function () {

    }
})