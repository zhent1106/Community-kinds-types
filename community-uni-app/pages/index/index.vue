<template>
	<view class="content">
		<view class="text-area">
			<!-- 音乐播放器 -->
			<myaudio></myaudio>
		</view>
	</view>
</template>

<script>
	
	import myaudio from '@/components/myaudio.vue'
	
	export default {
		components:{
			myaudio,
		},
		data() {
			return {
			}
		},
		onLoad() {

		},
		methods: {

		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
