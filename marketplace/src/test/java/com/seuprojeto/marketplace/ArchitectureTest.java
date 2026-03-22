package com.seuprojeto.marketplace;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import org.junit.jupiter.api.Test;

class ArchitectureTest {

    @Test
    void domainShouldNotDependOnOtherLayers() {

        var classes = new ClassFileImporter()
                .importPackages("com.seuprojeto.marketplace");

        ArchRuleDefinition.noClasses()
                .that().resideInAPackage("..domain..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("..application..", "..infrastructure..", "..presentation..")
                .check(classes);
    }
}