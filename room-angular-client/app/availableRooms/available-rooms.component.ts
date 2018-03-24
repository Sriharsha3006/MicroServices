import {Component} from '@angular/core'
import {IRooms} from '../service/room.module'
import {RoomService} from '../service/room.service'

@Component({
    templateUrl:'app/availableRooms/available-rooms.component.html'
    })
export class AvailableRoomsComponent{
    
    availableRoomsObj:IRooms[]
    sortBy:string='all'
    url:string = 'http://localhost:8888/Consumer/consumer/roomConsumer'
    constructor(private roomService:RoomService) {
       
        this.roomService.getRoomData(this.url).subscribe((response:IRooms[])=>this.availableRoomsObj=
        response.filter((room:IRooms)=>room.availability=='Available'));
           
    }
    
    sortByPrice():void{
        this.sortBy='price'; 
        console.log(this.sortBy)
        this.availableRoomsObj.sort(this.sortByPriceMax)
    }
    
    sortByNoOfRooms(){
        this.sortBy='rooms';
        console.log(this.sortBy) 
        this.availableRoomsObj.sort(this.sortByRoomsMax)
    }
    
    sortByPriceMax(r1:IRooms,r2:IRooms){
      if(r1.price>r2.price) return 1;
      else if(r1.price===r2.price) return 0;
      else return -1
    }
    
    sortByRoomsMax(r1:IRooms,r2:IRooms){
      if(r1.numPpl>r2.numPpl) return -1;
      else if(r1.numPpl===r2.numPpl) return 0;
      else return 1
    }
}