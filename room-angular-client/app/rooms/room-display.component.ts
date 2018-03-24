import {Component,Input} from '@angular/core'
import {IRooms} from '../service/room.module'

@Component({
    selector: 'room-display',
    templateUrl: 'app/rooms/room-display.component.html'
    })
export class RoomDisplayComponent{
        
    @Input() roomCommunication:IRooms
    
 }