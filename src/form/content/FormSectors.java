package form.content;

import mindustry.content.*;
import mindustry.type.*;

import static mindustry.content.Planets.*;
import static form.content.FormPlanets.*;

public class FormSectors {
    public static SectorPreset
    /* Serpulo */  deferhor, soleray,
    /* dawn */  lemans, konota, imposmor;

    public static void load() {
        deferhor = new SectorPreset("deferhor", Planets.serpulo, 280){{
            captureWave = 20;
            difficulty = 2;
        }};
        soleray = new SectorPreset("soleray", Planets.serpulo, 159){{
            captureWave = 20;
            difficulty = 2;
        }};
        //FIXME
        lemans = new SectorPreset("lemans", FormPlanets.mathurak, 150){{
            captureWave = 15;
            difficulty = 5;
        }};
        konota = new SectorPreset("konota", FormPlanets.mathurak, 180){{
            difficulty = 4;
        }};
		imposmor = new SectorPreset("imposmor", FormPlanets.mathurak, 200){{
			difficulty = 1;
			captureWave = 15;
		}};
    }
}
 