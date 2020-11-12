<template>
	<view>
		
	</view>
</template>

<script>
	import unit from '../../common/unit.js' ;
	import { mapState, mapGetters, mapMutations, mapActions } from 'vuex';
	export default {
		data() {
			return {
				
			}
		},
		filters:{
			formatTime(num){
				return unit.formatTime(num)
			}
		},
		computed: {
			...mapState({
				durationTime: ({ audio }) => audio.durationTime,
				currentTime: ({ audio }) => audio.currentTime,
				audioList:({audio}) =>audio.audioList
			}),
			...mapGetters(['audioName', 'singerName','singerSynopsis'])
		},
		methods: {
			...mapActions([
				'sliderToPlay'
			])
		}
	}
</script>

<style>

</style>
