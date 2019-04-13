import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { MenuService } from './service/menu.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'web-test';
  heros = ['hero1', 'hero2'];



  constructor(menuService: MenuService) {
    menuService.testPrint();
    menuService.testPrint();
  }

}
