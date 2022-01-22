export class Movies {
  id: number | undefined;
  title: string | undefined;
  season: number | undefined;
  episode: number | undefined;
  img: string | undefined;
  category: string | undefined;
  haveWatched: boolean | undefined;
  dateWatched: Date | undefined;
  dateScheduled: Date | undefined;


  constructor(
    id?: number | undefined,
    title?: string | undefined,
    season?: number | undefined,
    episode?: number | undefined,
    img?: string | undefined,
    category?: string | undefined,
    haveWatched?: boolean | undefined,
    dateWatched?: Date | undefined,
    dateScheduled?: Date | undefined
  ){
    this.id  = id;
    this.title = title;
    this.season = season;
    this.episode = episode;
    this.img = img;
    this.category =  category;
    this.haveWatched = haveWatched;
    this.dateWatched = dateWatched;
    this.dateScheduled = dateScheduled
  }
}
