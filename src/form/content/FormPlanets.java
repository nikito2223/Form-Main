package form.content;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import form.maps.generators.*;
import mindustry.Vars;
import mindustry.content.*;
import mindustry.game.Team;
import mindustry.graphics.g3d.*;
import mindustry.type.*;
import mindustry.world.meta.*;

import static mindustry.content.Planets.*;
import static form.content.FormBlocks.*;
import static form.content.FormTeam.*;
import static form.content.FormItems.*;
import static mindustry.type.Weather.*;

public class FormPlanets{

    public static Planet
        /* planets */ mathurak, Satellite, Tema,
		/*star*/ sakeru, sapuke;

    public static void load() {
        sakeru = new Planet("sakeru", Planets.sun, 4f, 2){{
            bloom = true;
			solarSystem = this;
			drawOrbit = false;
            accessible = false;
			lightColor = Color.valueOf("61b3f1");
            orbitRadius = 1000;
			hasAtmosphere = true;

            meshLoader = () -> new SunMesh(
                    this, 9,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("5fcde4"),
                    Color.valueOf("5fgce4"),
                    Color.valueOf("5s71cb"),
                    Color.valueOf("78fbe2")
					);
        }};
        sapuke = new Planet("sapuke", Planets.sun, 2f, 0){{
            bloom = false;
            accessible = false;
            hasAtmosphere = false;
            tidalLock = true;
			drawOrbit = false;
            orbitRadius = 40f;
            drawOrbit = false;
            meshLoader = () -> new SunMesh(
                    this, 9,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("78d242"),
                    Color.valueOf("4cac12"),
                    Color.valueOf("6faa4b"),
                    Color.valueOf("284615")
					);
            solarSystem = sakeru;
        }};
        Satellite = new Planet("Satellite", mathurak, 1f, 1) {{
            generator = new SatellitePlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
			defaultCore = FormBlocks.coretomer;
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 7, 0.1f, 0.28f, 5, Color.valueOf("efefef").a(0.75f), 2, 0.45f, 1.13f, 0.45f),
                new HexSkyMesh(this, 3, 0.2f, 0.23f, 5, Color.valueOf("afafaf").a(0.65f), 3, 0.25f, 1.22f, 0.45f),
                new HexSkyMesh(this, 2, 0.3f, 0.32f, 5, Color.valueOf("ffffff").a(0.55f), 4, 0.35f, 1.35f, 0.45f),
                new HexSkyMesh(this, 3, 0.3f, 0.32f, 5, Color.valueOf("cbcbcb").a(0.55f), 4, 0.35f, 1.35f, 0.45f)
            );
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.4f;
            orbitRadius = 30f;
            iconColor = Color.valueOf("9db1cc");
            atmosphereColor = Color.valueOf("003399");
            solarSystem = sakeru;
			
            startSector = 12;
            accessible = true;
            alwaysUnlocked = true;
            updateLighting = true;
            ruleSetter = r -> {
                r.fog = true;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.staticFog = true;
                r.lighting = true;
                r.coreDestroyClear = true;
            };
            unlockedOnLand.add(FormBlocks.coretomer);
        }};
        mathurak = new Planet("mathurak", sakeru, 1f, 3) {{
            generator = new MathurakPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 7);
            defaultCore = FormBlocks.coretomer;
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 7, 0.1f, 0.28f, 5, Color.valueOf("828282").a(0.75f), 2, 0.45f, 1.13f, 0.45f),
                    new HexSkyMesh(this, 3, 0.2f, 0.23f, 5, Color.valueOf("828282").a(0.65f), 3, 0.25f, 1.22f, 0.45f),
                    new HexSkyMesh(this, 2, 0.3f, 0.32f, 5, Color.valueOf("828282").a(0.55f), 4, 0.35f, 1.35f, 0.45f),
                    new HexSkyMesh(this, 3, 0.3f, 0.32f, 5, Color.valueOf("b9baba").a(0.55f), 4, 0.35f, 1.35f, 0.45f),
                    new HexSkyMesh(this, 2, 0.3f, 0.32f, 5, Color.valueOf("b9baba").a(0.55f), 4, 0.35f, 1.35f, 0.45f),
                    new HexSkyMesh(this, 7, 0.1f, 0.28f, 5, Color.valueOf("b9baba").a(0.75f), 2, 0.45f, 1.13f, 0.45f),
                    new HexSkyMesh(this, 3, 0.2f, 0.23f, 5, Color.valueOf("464647").a(0.65f), 3, 0.25f, 1.22f, 0.45f),
                    new HexSkyMesh(this, 3, 0.2f, 0.23f, 5, Color.valueOf("464647").a(0.65f), 3, 0.25f, 1.22f, 0.45f),
                    new HexSkyMesh(this, 3, 0.2f, 0.23f, 5, Color.valueOf("464647").a(0.65f), 3, 0.25f, 1.22f, 0.45f)
            );
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.4f;
            orbitRadius = 30f;
            iconColor = Color.valueOf("9db1cc");
            atmosphereColor = Color.valueOf("5s71cb");
            solarSystem = sakeru;

            startSector = 15;
            accessible = true;
            alwaysUnlocked = true;
            updateLighting = true;
            ruleSetter = r -> {
                r.fog = true;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.staticFog = true;
                r.lighting = true;
                r.coreDestroyClear = true;
            };
            unlockedOnLand.add(FormBlocks.coretomer);
        }};
		Tema = new Planet("Tema", Planets.sun, 1f, 2){{
            generator = new TemaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 8);
            accessible = true;
            alwaysUnlocked = true;
			solarSystem = sakeru;
			orbitRadius = 14f;
            updateLighting = true;
            atmosphereColor = Color.valueOf("3db899");
            iconColor = Color.valueOf("597be3");
            startSector = 10;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.4f;
            defaultEnv = Env.underwater | Env.terrestrial;
            ruleSetter = r -> {

            };
        }};
        //planeta sun
              //vanilla planets 
            serpulo.hiddenItems.addAll(mathurakItems).removeAll(Items.serpuloItems);
            erekir.hiddenItems.addAll(mathurakItems).removeAll(Items.erekirItems);

            // mod planets
           mathurak.hiddenItems.addAll(Vars.content.items()).removeAll(mathurakItems);
		   Satellite.hiddenItems.addAll(Vars.content.items()).removeAll(mathurakItems);

    }
}
