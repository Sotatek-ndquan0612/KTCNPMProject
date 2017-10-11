package View;

import java.util.ArrayList;

import Controller.BaseController;
import Event.Command;
import Model.H;
import Model.Hs;
import Model.YeuCauChucNang;
import ViewController.PanelQuanLy2;

public class PanelH extends PanelQuanLy2<YeuCauChucNang>{
	protected BaseController<YeuCauChucNang> controllerGlobal;
	public PanelH() {
		controllerGlobal = controller.takeConstroller(Command.CQuanLyDSYC);
		setInputContent(new HView());
		setBang(new BangH());
		setQuanLyView(new PanelThemSuaXoaH());
		setImportExcel(new PanelImportExcelTAW());
		setup();
		setTitle("H = 0");
		
	}
	@Override
	public void update(Command command, Object data) {
		// TODO Auto-generated method stub
		super.update(command, data);
		switch (command) {
		case RThemYC:
		H h = new H(Float.parseFloat((((HView)viewInput).getfMucLuong().getText())), Integer.parseInt((((HView)viewInput).getfSoCanBo().getText())));
		object.getListH().getListH().add(h);
		capNhatDuLieu(object.getListH());
		
			break;
		case RSuaYC:
		
			break;
		
		case RXoaYC:
			int count = bang.getSelectedRow();
			if(count == -1) return;
			object.getListH().getListH().remove(count);
			capNhatDuLieu(object.getListH());
			break;

		default:
			break;
		}
	}
	private void capNhatDuLieu(Hs data) {
		// TODO Auto-generated method stub
		bang.setInputData(data);
	}

}
