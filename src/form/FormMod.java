package form;

// Arc Package
import arc.*;
import arc.math.*;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;
import arc.util.*;
// Mindustry Package

import mindustry.content.SectorPresets;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.ui.Styles;
import mindustry.ui.fragments.MenuFragment;
import mindustry.ui.dialogs.*;
// Vanilla Upgraded Package
import form.content.*;
//static
import static arc.Core.*;
import static mindustry.Vars.*;
import static mindustry.game.EventType.*;
// End

public class FormMod extends Mod{

    public FormMod(){
    	Log.info("Start.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Asmha");
                dialog.cont.add("Asmha").pad(50f).row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("form-frog")).row();
                dialog.cont.button("Yes", dialog::hide).size(100f, 50f);
                dialog.cont.button("No", dialog::hide).size(100f, 50f);
                dialog.show();
				jlhg
            });
        });
    }
     @Override
    public void loadContent(){
        FormAttributes.load();
        FormWeathers.load();
        FormItems.load();
        FormLiquid.load();
        new FormSchematics().load();
        new FormUnits().load();
        FormBlocks.load();
        FormPlanets.load();
        FormSectors.load();

        //TechTree
        SerpuloTechTree.load();
        MathurakTechTree.load();
    }
}
