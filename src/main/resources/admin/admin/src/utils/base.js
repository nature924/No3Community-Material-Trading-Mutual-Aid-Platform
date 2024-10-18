const base = {
    get() {
        return {
            url : "http://localhost:8080/shequwuzijiaoyipingtai/",
            name: "shequwuzijiaoyipingtai",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/shequwuzijiaoyipingtai/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "社区物资交易互助平台"
        } 
    }
}
export default base
