<template>
      <section>
        <div class="comic-carousel">
        
        <b-carousel-list
            v-model="values"
            :data="items"
            :arrow="arrow"
            :arrow-hover="arrowHover"
            :items-to-show="perList"
            :items-to-list="increment"
            :repeat="repeat"
            :has-drag="drag"
            :has-grayscale="gray"
            :has-opacity="opacity" />
            </div>
    </section>
</template>

<script>
export default {
    data() {
        return {
            arrow: true,
            arrowHover: true,
            drag: true,
            gray: false,
            opacity: false,
            values: 1,
            perList: 4,
            increment: 1,
            repeat: false,
            items: [
                {
                    alt: 'Slide 1',
                    title: 'Slide 1',
                    image: 'http://i.annihil.us/u/prod/marvel/i/mg/d/a0/6376862228a60/portrait_uncanny.jpg',
                    srcFallback: 'https://picsum.photos/id/0/1230/500'
                },
                {
                    title: 'Slide 2',
                    image: 'https://i.annihil.us/u/prod/marvel/i/mg/5/50/613ac55a0070d/clean.jpg'
                },
                {
                    title: 'Slide 3',
                    image: 'http://i.annihil.us/u/prod/marvel/i/mg/4/10/63863d39737ad/portrait_uncanny.jpg'
                },
                {
                    title: 'Slide 4',
                    image: 'http://i.annihil.us/u/prod/marvel/i/mg/2/50/63613a2c207b0/portrait_uncanny.jpg'
                },
                {
                    title: 'Slide 5',
                    image: 'http://i.annihil.us/u/prod/marvel/i/mg/4/80/63863cee78368/portrait_uncanny.jpg'
                },
                {
                    title: 'Slide 6',
                    image: 'http://i.annihil.us/u/prod/marvel/i/mg/9/d0/5e289207bf6ce/portrait_uncanny.jpg'
                },
                {
                    title: 'Slide 7',
                    image: 'http://i.annihil.us/u/prod/marvel/i/mg/5/e0/632dad721108f/portrait_uncanny.jpg'
                },
                {
                    title: 'Slide 8',
                    image: 'http://i.annihil.us/u/prod/marvel/i/mg/4/03/6344254095ac5/portrait_uncanny.jpg'
                }
            ]
        }
    }
}
</script>

<style scoped>
.comic-carousel{
    padding-left: 100px;
    padding-top: 0px;
    width: 160vh;
    display: grid;
    justify-items: center;
    
}
section{
    display:grid;
    justify-items: center;
    padding-right: 200px;
    padding-left: 250px;
    padding-top: 40px;
}
div.carousel-list.has-shadow{
    height: 500px;
    width: 1500px;
}
</style>