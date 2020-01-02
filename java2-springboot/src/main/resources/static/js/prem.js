//自定义vue指令
Vue.directive("perm",{
	inserted:function(el,binding,vnode){
		let perm = sessionStorage.getItem("perm");
		perm = JSON.parse(perm);
		let flag = perm.some(p=>{
			return binding.value==p.path;
		});
		if(flag==false){
			el.remove();
		}
	}
});