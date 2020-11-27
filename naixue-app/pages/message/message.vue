<template>
	<view class="content">
		<view class="input_box"> 
			<textarea placeholder="请输入您要留言的内容" class="textarea border" v-model="message.content"/>
			<input type="text" class="input_box1 border" v-model="message.name" placeholder="请输入用户名:"/>
			<button @click="addMsg" class="submit" >提交</button>
		</view>
		
		<view class="list">
			<view class="item" v-for="(item,index) in listData" :key="index">
				<view class="word">
					<text class="user_name">{{ item.name }}:  </text>
					<text class="content"> {{ item.content }}</text>
				</view>
				<text  class="delete" @click="removeMsg(item._id)">删除</text>
			</view>
			
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				message:{
					name:'',
					content:''
				},
				listData:[
					{
						_id:'',
						name:'',
						content:''
					}
				]
			};
		},
		onLoad() {
			this.getData();
		},
		methods:{
			addMsg() {
				let data = this.message;
				uniCloud.callFunction({
					name:'add',
					data:data
				}).then(res => {
					this.getData();
					this.message.name = '';
					this.message.content = '';
				});
			},
			getData() {
				uniCloud.callFunction({
					name:'get'
				}).then(res => {
					this.listData = res.result.data;
				});
			},
			removeMsg(id) {
				console.log(id);
				let _id = id;
				uniCloud.callFunction({
					name:'remove',
					data:{
						_id
					}
				}).then(res => {
					this.getData();
				})
			}
		}
	}
</script>

<style lang="scss">
	.textarea  {
		padding-top: 10rpx;
		border: 1px solid #dfdfd8;
		width: 100%;
		margin-top: 10rpx;
		padding-left: 10rpx;
	}
	.input_box1{
		padding-bottom: 20rpx;
		border: 1px solid #dfdfd8;
		width: 100%;
		margin-top: 10rpx;
		padding-left: 10rpx;
		margin-bottom: 15rpx;
	}
	.user_name {
		font-size: 40rpx;
		color: #94a2ff;
		
	}
.content {
	font-size: 30rpx;
	color: #999;
}
.delete {
	background-color: #94a2ff;
	color: #e5e5e5;
	font-size: 25rpx;
	padding: 10rpx 20rpx;
	margin-top: 20rpx;
	border-radius: 8rpx;
}
.item {
	margin-top: 60rpx;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	align-items: flex-start;
	padding-left: 20rpx;
}
.input_box {
	padding-left: 20rpx;
	padding-right: 30rpx;
}
.submit{
	background-color: #94a2ff;
	color: #FFFFFF;
}
</style>
