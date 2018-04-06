import {Component} from '@angular/core'
import {IRooms} from '../service/room.module'
import {RoomService} from '../service/room.service'
import {ActivatedRoute, Router} from '@angular/router'

@Component({
    template:`
    <img src="app/assets/images/room.jpg">
    <div *ngFor="let ro of room">
        <room-display #thumbnail [roomCommunication]="ro"></room-display>
    </div>
    <div>
        <button (click)=bookARoom()>Book This Room</button>
    </div>
    `
})
export class BookRoomComponent{
    
    room:IRooms[];
    url:string = 'http://room-app-loadbalancer-398262411.us-west-2.elb.amazonaws.com/Consumer/consumer/roomConsumer?roomNumber='
    constructor(private roomService:RoomService,private route:ActivatedRoute, private router:Router) {
       console.log(this.route.snapshot.params['roomNumber'])
        this.url=this.url+this.route.snapshot.params['roomNumber']
        this.roomService.getRoomData(this.url).subscribe((response:IRooms[])=>this.room=response);
    }

    bookARoom() {
        let urlForBookRoom='http://room-app-loadbalancer-398262411.us-west-2.elb.amazonaws.com/Producer/producer/bookARoom/'+this.room[0].roomNumber
        this.room[0].availability="Not Available"
        this.roomService.bookARoom(urlForBookRoom,this.room[0]).subscribe((roomjson)=>{
            this.router.navigate(['/congratulations'])
        })
    }
    
}