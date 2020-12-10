public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cy = new Cylinder();

        cy.setRadius(2.2);
        cy.setLength(22.1);

        double volume = cy.findVolume();
        System.out.println(volume);
        double area = cy.findArea();
        System.out.println(area);

    }
}
